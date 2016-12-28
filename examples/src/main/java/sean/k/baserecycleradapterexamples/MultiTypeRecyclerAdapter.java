package sean.k.baserecycleradapterexamples;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import sean.k.baserecycleradapter.BaseRecyclerAdapter;
import sean.k.baserecycleradapter.BaseRecyclerViewHolder;

public class MultiTypeRecyclerAdapter extends BaseRecyclerAdapter {

    static final int ITEM_TYPE_IMAGE = 1;
    static final int ITEM_TYPE_TEXT = 2;
    static final int ITEM_TYPE_INTEGER = 3;

    @Override
    public BaseRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case ITEM_TYPE_IMAGE:
                return new ImageViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.li_image, parent, false));
            case ITEM_TYPE_TEXT:
                return new TextViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.li_text, parent, false));
            case ITEM_TYPE_INTEGER:
                return new IntegerViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.li_integer, parent, false));
        }
        return null;
    }

    private static class ImageViewHolder extends BaseRecyclerViewHolder<ImageViewModel> {

        private ImageView mImageView;

        private ImageViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.image_view);
        }

        @Override
        public void setContent(ImageViewModel viewModel) {
            Picasso.with(itemView.getContext())
                    .load(viewModel.data)
                    .resize(itemView.getResources().getDimensionPixelSize(R.dimen.image_height),
                            itemView.getResources().getDimensionPixelSize(R.dimen.image_height))
                    .centerCrop()
                    .into(mImageView);
        }
    }

    private static class TextViewHolder extends BaseRecyclerViewHolder<TextViewModel> {

        private TextView mTextView;

        private TextViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.text_view);
        }

        @Override
        public void setContent(TextViewModel viewModel) {
            mTextView.setText(viewModel.data);
        }
    }

    private static class IntegerViewHolder extends BaseRecyclerViewHolder<IntegerViewModel> {

        private TextView mTextView;

        IntegerViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.integer_text_view);
        }

        @Override
        public void setContent(IntegerViewModel viewModel) {
            mTextView.setText(String.valueOf(viewModel.data));
        }
    }
}
