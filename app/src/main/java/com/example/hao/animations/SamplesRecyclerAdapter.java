package com.example.hao.animations;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hao.animations.databinding.RowSampleBinding;

import java.util.List;

/**
 * Created by hao on 2016-09-13.
 */
public class SamplesRecyclerAdapter extends RecyclerView.Adapter<SamplesRecyclerAdapter.SamplesViewHolder>{

    private final Activity mActivity;
    private final List<Sample> mSamples;

    public SamplesRecyclerAdapter(Activity activity, List<Sample> samples){
        this.mActivity = activity;
        this.mSamples = samples;

    }

    @Override
    public SamplesRecyclerAdapter.SamplesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RowSampleBinding binding = RowSampleBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new SamplesViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(final SamplesRecyclerAdapter.SamplesViewHolder holder, final int position) {
        final Sample sample = mSamples.get(holder.getAdapterPosition());
        holder.mBinding.setSample(sample);
        holder.mBinding.sampleLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (holder.getAdapterPosition()){
                    case 0:

                        break;
                    case 1:

                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    default:
                        break;
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mSamples.size();
    }

    public class SamplesViewHolder extends RecyclerView.ViewHolder{
        final RowSampleBinding mBinding;

        public SamplesViewHolder(View itemView) {
            super(itemView);
            mBinding = DataBindingUtil.bind(itemView);
        }
    }
}
