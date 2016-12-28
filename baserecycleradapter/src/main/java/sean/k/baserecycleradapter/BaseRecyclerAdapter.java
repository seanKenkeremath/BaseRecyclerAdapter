package sean.k.baserecycleradapter;

import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseRecyclerAdapter extends RecyclerView.Adapter<BaseRecyclerViewHolder> {

    protected List<BaseRecyclerViewModel> items;

    public BaseRecyclerAdapter(List<BaseRecyclerViewModel> items) {
        this.items = items;
    }

    public BaseRecyclerAdapter() {
        this.items = new ArrayList<>();
    }

    public void clearItems() {
        this.items.clear();
        notifyDataSetChanged();
    }

    public void setContent(List<BaseRecyclerViewModel> items) {
        this.items.clear();
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    public void addItem(BaseRecyclerViewModel item) {
        this.items.add(item);
        notifyItemInserted(items.size() - 1);
    }

    public void addItem(BaseRecyclerViewModel item, int position) {
        this.items.add(position, item);
        notifyItemInserted(position);
    }

    public void addItemWithoutAnimation(BaseRecyclerViewModel item) {
        this.items.add(item);
        notifyDataSetChanged();
    }

    public void removeItem(int position) {
        items.remove(position);
        notifyItemRemoved(position);
    }

    public BaseRecyclerViewModel getItem(int position) {
        return items.get(position);
    }

    public List<BaseRecyclerViewModel> getItems() {
        return items;
    }


    @Override
    public void onBindViewHolder(BaseRecyclerViewHolder holder, int position) {
        holder.setContent(items.get(position));
    }

    @Override
    public int getItemViewType(int position) {
        return items.get(position).type;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
