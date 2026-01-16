package vtb.itd.cba.explorerItem;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ExplorerItemServiceInterface {
    List<ExplorerItem> findRootItems();

    List<ExplorerItem> findChildrenItems(Long parentId);

    ExplorerItem saveFolder(ExplorerItem explorerItem);

    List<ExplorerItem> uploadFile(MultipartFile[] files, Long parentId);

    String deleteExplorerItem(List<ExplorerItem> explorerItems);


}
