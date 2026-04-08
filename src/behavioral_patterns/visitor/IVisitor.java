package behavioral_patterns.visitor;

public interface IVisitor {
  void visit(StandardBedroom room);

  void visit(DeluxeRoom room);

  void visit(SuiteRoom room);
}
