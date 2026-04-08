package behavioral_patterns.visitor;

public interface IRoom {
  void accept(IVisitor visitor);
}
