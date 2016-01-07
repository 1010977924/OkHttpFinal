package cn.finalteam.okhttpfinal.sample;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.finalteam.okhttpfinal.dm.DownloadManager;
import cn.finalteam.okhttpfinal.dm.db.FileDownloadInfo;
import cn.finalteam.okhttpfinal.sample.adapter.DownloadManagerListAdapter;
import us.feras.mdv.MarkdownView;

/**
 * Desction:
 * Author:pengjianbo
 * Date:15/9/29 下午5:43
 */
public class DownloadManangerActivity extends BaseActivity {

    @Bind(R.id.lv_task_list)
    ListView mLvTaskList;
    @Bind(R.id.mv_code)
    MarkdownView mMvCode;

    private DownloadManagerListAdapter mDownloadManagerListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_manager);
        ButterKnife.bind(this);

        setTitle("下载管理");
        List<FileDownloadInfo> list = DownloadManager.getInstance().getAllTask();
        mDownloadManagerListAdapter = new DownloadManagerListAdapter(this, list);
        mLvTaskList.setAdapter(mDownloadManagerListAdapter);

        mMvCode.loadMarkdownFile("file:///android_asset/DownloadManager.md", "file:///android_asset/css-themes/classic.css");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_code, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if ( itemId == R.id.action_code ) {
            if (mMvCode.getVisibility()== View.VISIBLE) {
                mMvCode.setVisibility(View.GONE);
            } else {
                mMvCode.setVisibility(View.VISIBLE);
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
