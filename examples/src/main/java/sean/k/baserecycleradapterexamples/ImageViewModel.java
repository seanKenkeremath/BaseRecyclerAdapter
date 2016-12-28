package sean.k.baserecycleradapterexamples;

import sean.k.baserecycleradapter.BaseRecyclerViewModel;

public class ImageViewModel extends BaseRecyclerViewModel<String> {
    public ImageViewModel(String url) {
        super(url, MultiTypeRecyclerAdapter.ITEM_TYPE_IMAGE);
    }
}
