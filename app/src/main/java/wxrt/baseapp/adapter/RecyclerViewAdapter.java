package wxrt.baseapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import wxrt.baseapp.R;
import wxrt.baseapp.bean.DouBean;

/**
 * Created by Mr.ZCM on 2016/4/25.
 * QQ:656025633
 * Company:winsion
 * Version:1.0
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private List<DouBean.SubjectsBean> mList;
    public RecyclerViewAdapter(Context context, List<DouBean.SubjectsBean> datas) {
        mContext = context;
        mList = datas;
    }
    public void addData(List<DouBean.SubjectsBean> datas){
        if(mList != null){
            mList.addAll(datas);
        }
    }
    public void clearData() {
        if (mList != null) {
            mList.clear();
        }
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.movieitem,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(mList == null){
            return ;
        }
        MyViewHolder viewHolder= (MyViewHolder)holder;
        //设置电影名称
        viewHolder.mMovieName.setText(mList.get(position).getTitle()+"("+mList.get(position).getYear()+")");
        //设置电影演员名称
        String  starName ="";
        for (int i = 0; i <mList.get(position).getCasts().size() ; i++) {
            if(i<mList.get(position).getCasts().size()-1) {
                starName += mList.get(position).getCasts().get(i).getName() + "/";
            }
            else{
                starName += mList.get(position).getCasts().get(i).getName();
            }
        }
        viewHolder.mMovieStar.setText(starName);
        //设置电影图片
        String imageUrl = mList.get(position).getImages().getMedium();
        Glide.with(mContext).load(imageUrl).into(viewHolder.mMovieImage);
    }

    @Override
    public int getItemCount() {
        if(mList == null){
            return  0;
        }
        return mList.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView mMovieName,mMovieStar;
        ImageView mMovieImage;
        public MyViewHolder(View itemView) {
            super(itemView);
            mMovieName = (TextView) itemView.findViewById(R.id.tv_movieName);
            mMovieStar = (TextView) itemView.findViewById(R.id.tv_star);
            mMovieImage = (ImageView)itemView.findViewById(R.id.img_movieImage);
        }
    }
}
