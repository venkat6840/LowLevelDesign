package structural_patterns.composite.filestructure;

public class File implements FileSystem {
  String fileName;

  public File(String name) {
    this.fileName = name;
  }

  @Override
  public void printContents() {
    System.out.println("This is the file name " + fileName);
  }
}
