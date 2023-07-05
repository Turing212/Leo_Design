package LeoDesign.model.storage;

public class Paginator {
    private final int limit;
    private final int offset;

    public Paginator(int pagina, int itemsPerPagina) {
        this.limit = itemsPerPagina;
        this.offset = (pagina -1) * itemsPerPagina + 1;
    }

    public int getLimit() {
        return limit;
    }

    public int getOffset() {
        return offset;
    }
}
