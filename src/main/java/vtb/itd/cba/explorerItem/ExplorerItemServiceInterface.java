package vtb.itd.cba.explorerItem;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ExplorerItemServiceInterface {
    List<ExplorerItem> findRootItems();

    Page<ExplorerItem> findChildrenItems(ExplorerItem explorerItem);

    ExplorerItem saveFolder(ExplorerItem explorerItem);


    String deleteExplorerItem(List<ExplorerItem> explorerItems);

    ExplorerItem changeNameFolder(ExplorerItem explorerItem);
}
