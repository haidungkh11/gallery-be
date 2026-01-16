package vtb.itd.cba.explorerItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExplorerItemRepository extends JpaRepository<ExplorerItem,Long> {
    @Query(value = "select * from explorer_item ei where ei.parent_id is null ", nativeQuery = true)
    List<ExplorerItem> findRootItems();

    @Query(value = "select * from explorer_item ei where ei.parent_id = ?1 ", nativeQuery = true)
    List<ExplorerItem> findChildrenItems(Long parentId);

    @Query(value = "select exists (select 1 from explorer_item e where e.parent_id = ?1)", nativeQuery = true)
    boolean existsChildrenItem(Long parentId);
}
