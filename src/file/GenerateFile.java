package file;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GenerateFile {
    public static void main(String[] args) {
        String rootModelDir = "xxxmodel_namexxx";

        // 生成文件夹
        File model = new File(rootModelDir + File.separator + "domain" + File.separator + "model");
        File service = new File(rootModelDir + File.separator + "domain" + File.separator + "service");
        File persistence = new File(rootModelDir + File.separator + "infrustrature" + File.separator + "persistence");
        File serviceImpl = new File(rootModelDir + File.separator + "infrustrature" + File.separator + "service");

        List<File> fileList = new ArrayList<>();
        fileList.add(model);
        fileList.add(service);
        fileList.add(persistence);
        fileList.add(serviceImpl);
        // 生成文件夹
        fileList.forEach(File::mkdirs);

        // 生成文件
        fileList.forEach(file -> {
            file.getAbsoluteFile().getPath();
            String dir = file.getParentFile().getName() + File.separator + file.getName();
            switch (dir) {
                case "domain/model":
                    System.out.println(dir);
                    File modelFile = new File(rootModelDir + File.separator + dir + File.separator + "a.java");
                    try {
                        boolean newFile = modelFile.createNewFile();
                        System.out.println(newFile);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case "domain/service":
                    System.out.println(2);
                    break;
                case "infrustrature/persistence":
                    System.out.println(3);
                    break;
                case "infrustrature/service":
                    System.out.println(4);
                    break;
            }
        });

    }
}
