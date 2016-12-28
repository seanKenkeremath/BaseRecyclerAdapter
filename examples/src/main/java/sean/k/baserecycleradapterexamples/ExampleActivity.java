package sean.k.baserecycleradapterexamples;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import sean.k.baserecycleradapter.BaseRecyclerViewModel;

public class ExampleActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private MultiTypeRecyclerAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);
        
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mAdapter = new MultiTypeRecyclerAdapter();

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setContent(getContent());
    }
    
    private List<BaseRecyclerViewModel> getContent() {
        List<BaseRecyclerViewModel> returnList = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            returnList.add(new IntegerViewModel(i));
            returnList.add(new TextViewModel(UUID.randomUUID().toString()));
            returnList.add(new ImageViewModel("http://vignette3.wikia.nocookie.net/timanderic/images/9/93/Spagetface.png/revision/latest?cb=20080223000947"));
        }
        return returnList;
    }
}
