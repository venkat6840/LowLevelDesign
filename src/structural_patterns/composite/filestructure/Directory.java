package structural_patterns.composite.filestructure;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystem {
  private String directoryName;
  List<FileSystem> children;

  Directory(String directoryName) {
    this.directoryName = directoryName;
    children = new ArrayList<>();
  }

  public void add(FileSystem fileSystem) {
    children.add(fileSystem);
  }

  public void removeFile(FileSystem fileSystem) {
    children.remove(fileSystem);
  }

  @Override
  public void printContents() {
    System.out.println("Directory Name: " + directoryName);
    for (FileSystem fileSystem : children) {
      fileSystem.printContents();
    }
  }
}
