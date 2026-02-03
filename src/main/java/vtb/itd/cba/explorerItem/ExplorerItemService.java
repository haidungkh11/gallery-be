package vtb.itd.cba.explorerItem;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import vtb.itd.cba.config.AppException;
import vtb.itd.cba.config.CodeDefs;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExplorerItemService implements ExplorerItemServiceInterface{

    private final ExplorerItemRepository explorerItemRepository;

    private final FileStorageService fileStorageService;
    @Override
    public List<ExplorerItem> findRootItems() {
        return explorerItemRepository.findRootItems();
    }

    @Override
    public Page<ExplorerItem> findChildrenItems(ExplorerItem explorerItem) {
        Pageable pageable = PageRequest.of(explorerItem.getPage(), explorerItem.getSize(), Sort.by(Sort.Direction.DESC, "modifiedTime"));
        return explorerItemRepository.findExplorerItemsByParentId(explorerItem.getParentId(), pageable);
    }

    @Override
    @Transactional
    public ExplorerItem saveFolder(ExplorerItem explorerItem) {
        explorerItem.setId(null);
        return explorerItemRepository.save(explorerItem);
    }


    @Override
    @Transactional
    public List<ExplorerItem> uploadFile(MultipartFile[] files, Long parentId) {

        List<ExplorerItem> result = new ArrayList<>();

        for (MultipartFile file : files) {
            try {
                String path = fileStorageService.save(file);

                ExplorerItem item = new ExplorerItem();
                item.setName(file.getOriginalFilename());
                item.setType(file.getContentType().startsWith("video") ? "VIDEO" : "IMAGE");
                item.setParentId(parentId == -1 ? null : parentId);
                item.setUrl("/images/" + path);

                result.add(explorerItemRepository.save(item));

            }  catch (IOException e) {
                throw new AppException(CodeDefs.RETURN_CODE_EXCEPTION);
            }
        }
        return result;
    }

    @Transactional
    @Override
    public String deleteExplorerItem(List<ExplorerItem> explorerItems) {


        for (ExplorerItem e : explorerItems){
            ExplorerItem item = explorerItemRepository.findById(e.getId())
                    .orElseThrow(() ->  new AppException(CodeDefs.RETURN_CODE_EXCEPTION));

            boolean existChildrenItem = explorerItemRepository.existsChildrenItem(item.getId());
            if(existChildrenItem){
                throw new AppException(CodeDefs.RETURN_CODE_EXIST_CHILDREN_ITEM);
            }

            // Xóa file vật lý
            if(!item.getType().equals("FOLDER")){
                int index = item.getUrl().indexOf("/files");

                fileStorageService.delete(index != -1 ? item.getUrl().substring(index + "/files".length()) : null);
            }
            // Xóa DB
            explorerItemRepository.delete(item);
        }

        return "OK";
    }

    @Override
    @Transactional
    public ExplorerItem changeNameFolder(ExplorerItem explorerItem) {
        Optional<ExplorerItem> explorerItem1 = explorerItemRepository.findById(explorerItem.getId());
        if(explorerItem1.isPresent()){
            explorerItem1.get().setName(explorerItem.getName());
            return explorerItemRepository.save(explorerItem1.get());
        }
        throw new AppException(CodeDefs.RETURN_CODE_NOT_FOUND);
    }


}
