package vtb.itd.cba.explorerItem;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import vtb.itd.cba.util.LogUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.UUID;

@Service
public class FileStorageService {

    private final String rootDir = "/home/ledung/IdeaProjects/data/upload";

    public String save(MultipartFile file) throws IOException {
        try {
            LogUtil.Info("BEGIN FileStorageService ");
            LocalDate now = LocalDate.now();
            String year = String.valueOf(now.getYear());
            String month = String.format("%02d", now.getMonthValue()); // 01, 02...

            // 2. Tạo path: ROOT/2026/01

            Path uploadDir = Paths.get(rootDir, year, month);

            // 3. Nếu chưa tồn tại → tạo
            if (!Files.exists(uploadDir)) {
                Files.createDirectories(uploadDir);
            }

            // 4. Tạo tên file an toàn
            String originalName = file.getOriginalFilename();
            String extension = "";

            if (originalName != null && originalName.contains(".")) {
                extension = originalName.substring(originalName.lastIndexOf("."));
            }

            String filename = UUID.randomUUID() + extension;

            // 5. Ghi file ra disk
            Path targetPath = uploadDir.resolve(filename);
            Files.copy(file.getInputStream(), targetPath, StandardCopyOption.REPLACE_EXISTING);
            LogUtil.Info("UPLOAD ROOT DIR = " + uploadDir.toAbsolutePath());
            LogUtil.Info("TARGET PATH = " + targetPath.toAbsolutePath());

            LogUtil.Info("END FileStorageService ");
            LogUtil.Info("File is null: " + (file == null));
            LogUtil.Info("File is empty: " + file.isEmpty());
            LogUtil.Info("File size: " + file.getSize());
            LogUtil.Info("File name: " + file.getOriginalFilename());
            LogUtil.Info("Content type: " + file.getContentType());

            // 6. Trả về path để lưu DB (URL public)
            return year + "/" + month + "/" + filename;

        } catch (IOException e) {
            LogUtil.Info(e.getMessage());
            throw new RuntimeException("Cannot store file", e);
        }
    }
    public void delete(String relativePath) {

        if (relativePath == null || relativePath.isBlank()) {
            return;
        }

        try {
            // 1. Ghép full path
            Path filePath = Paths.get(rootDir + relativePath);

            // 2. Security check – chống ../ traversal
            if (!filePath.startsWith(Paths.get(rootDir))) {
                throw new SecurityException("Invalid file path");
            }

            // 3. Xóa nếu tồn tại
            Files.deleteIfExists(filePath);

        } catch (IOException e) {
            throw new RuntimeException("Cannot delete file: " + relativePath, e);
        }
    }
}
