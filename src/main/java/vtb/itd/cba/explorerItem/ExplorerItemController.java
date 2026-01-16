package vtb.itd.cba.explorerItem;

import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import vtb.itd.cba.config.CodeDefs;
import vtb.itd.cba.response.ResponseObject;
import vtb.itd.cba.util.LogUtil;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ExplorerItemController {
    private final ExplorerItemServiceInterface explorerItemService;

    @GetMapping(value = "/api/ledung/gallery/findRootItem")
    ResponseEntity<ResponseObject<List<ExplorerItem>>> listAllItemRoot(@RequestHeader("RequestId") String requestId){
        LogUtil.Info("BEGIN CONTROLLER listAllItemRoot with requestId: " + requestId);

        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseObject<>(
                        requestId,
                        CodeDefs.RETURN_CODE_SUCCEED.getStatusCode(),
                        CodeDefs.RETURN_CODE_SUCCEED.getDescription(),
                        explorerItemService.findRootItems()
                ));
    }

    @PostMapping(value = "/api/ledung/gallery/findChildrenItem")
    ResponseEntity<ResponseObject<List<ExplorerItem>>> findChildrenItem(@RequestHeader("RequestId") String requestId,
                                                                        @RequestBody ExplorerItem explorerItem){
        LogUtil.Info("BEGIN CONTROLLER findChildrenItem with requestId: " + requestId);

        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseObject<>(
                        requestId,
                        CodeDefs.RETURN_CODE_SUCCEED.getStatusCode(),
                        CodeDefs.RETURN_CODE_SUCCEED.getDescription(),
                        explorerItemService.findChildrenItems(explorerItem.getParentId())
                ));
    }
    @PostMapping(value = "/api/ledung/gallery/createFolder")
    ResponseEntity<ResponseObject<ExplorerItem>> createFolder(@RequestHeader("RequestId") String requestId,
                                                                        @RequestBody ExplorerItem explorerItem){
        LogUtil.Info("BEGIN CONTROLLER findChildrenItem with requestId: " + requestId);

        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseObject<>(
                        requestId,
                        CodeDefs.RETURN_CODE_SUCCEED.getStatusCode(),
                        CodeDefs.RETURN_CODE_SUCCEED.getDescription(),
                        explorerItemService.saveFolder(explorerItem)
                ));
    }
    @PostMapping(value = "/api/ledung/gallery/uploadFile",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ResponseObject<List<ExplorerItem>>> uploadFile(
            @RequestHeader("RequestId") String requestId,
            @RequestPart("files") MultipartFile[] files,
            @RequestHeader(value = "ParentId",required = false) Long parentId) {

        LogUtil.Info("BEGIN CONTROLLER uploadFile with requestId: " + requestId);

        return ResponseEntity.ok(
                new ResponseObject<>(
                        requestId,
                        CodeDefs.RETURN_CODE_SUCCEED.getStatusCode(),
                        CodeDefs.RETURN_CODE_SUCCEED.getDescription(),
                        explorerItemService.uploadFile(files, parentId)
                )
        );
    }

    @PostMapping(value = "/api/ledung/gallery/deleteItem")
    ResponseEntity<ResponseObject<String>> deleteItem(@RequestHeader("RequestId") String requestId,
                                                 @RequestBody List<ExplorerItem> explorerItem){
        LogUtil.Info("BEGIN CONTROLLER findChildrenItem with requestId: " + requestId);

        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseObject<>(
                        requestId,
                        CodeDefs.RETURN_CODE_SUCCEED.getStatusCode(),
                        CodeDefs.RETURN_CODE_SUCCEED.getDescription(),
                        explorerItemService.deleteExplorerItem(explorerItem)
                ));
    }

}
