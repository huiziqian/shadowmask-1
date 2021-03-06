package org.shadowmask.core.domain.tree;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * domain tree node
 */
public class DomainTreeNode<N extends DomainTreeNode> {

  private static AtomicInteger cnt = new AtomicInteger(0);

  private int id;

  private String name;

  private transient N parent;

  private List<N> children;

  private int depth;

  public DomainTreeNode() {
    id = cnt.incrementAndGet();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public N getParent() {
    return parent;
  }

  public void setParent(N parent) {
    this.parent = parent;
  }

  public List<N> getChildren() {
    return children;
  }

  public void setChildren(List<N> children) {
    this.children = children;
  }

  public int getDepth() {
    return depth;
  }

  public void setDepth(int depth) {
    this.depth = depth;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override public String toString() {
    String res = "";
    DomainTreeNode pointer = this;
    while (pointer.getParent() != null) {
      res = "->" + pointer.getName() + res;
      pointer = pointer.getParent();
    }
    res = pointer.getName() + res;
    return res;
  }

  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    DomainTreeNode<?> that = (DomainTreeNode<?>) o;

    return id == that.id;
  }

  @Override public int hashCode() {
    return id;
  }
}
