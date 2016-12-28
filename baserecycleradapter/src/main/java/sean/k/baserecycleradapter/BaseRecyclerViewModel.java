package sean.k.baserecycleradapter;

public class BaseRecyclerViewModel<T> {
    public final T data;
    public final int type;

    public BaseRecyclerViewModel(T data, int type) {
        this.data = data;
        this.type = type;
    }
}
