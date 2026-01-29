package vtb.itd.cba.explorerItem;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import vtb.itd.cba.config.AppException;
import vtb.itd.cba.config.CodeDefs;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
    public List<ExplorerItem> findChildrenItems(Long parentId) {
        return explorerItemRepository.findChildrenItems(parentId);
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


}
