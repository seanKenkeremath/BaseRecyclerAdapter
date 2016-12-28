package sean.k.baserecycleradapterexamples;

import sean.k.baserecycleradapter.BaseRecyclerViewModel;

public class IntegerViewModel extends BaseRecyclerViewModel<Integer> {
    public IntegerViewModel(Integer data) {
        super(data, MultiTypeRecyclerAdapter.ITEM_TYPE_INTEGER);
    }
}
