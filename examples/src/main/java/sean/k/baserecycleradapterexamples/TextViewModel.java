package sean.k.baserecycleradapterexamples;

import sean.k.baserecycleradapter.BaseRecyclerViewModel;

public class TextViewModel extends BaseRecyclerViewModel<String> {
    public TextViewModel(String data) {
        super(data,  MultiTypeRecyclerAdapter.ITEM_TYPE_TEXT);
    }
}
