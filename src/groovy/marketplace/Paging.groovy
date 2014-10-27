package marketplace

interface Paging<T> extends Collection<T> {
    Integer getOffset();
    Integer getMax();
    int getTotal();
}
