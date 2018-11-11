package com.muryno.listedkey.pagingAdapter.adater;

import android.arch.paging.PagedListAdapter;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.muryno.listedkey.R;
import com.muryno.listedkey.databinding.MainUiListingBinding;
import com.muryno.listedkey.databinding.NetworkFailureListItemBinding;
import com.muryno.listedkey.databinding.LoadingListItemBinding;

import com.muryno.listedkey.model.MainLst;

import com.muryno.listedkey.pagingAdapter.NetworkState;


public class PageAdapter  extends PagedListAdapter<MainLst, RecyclerView.ViewHolder> {
    private final Callback callback;
    private Context context;
    private NetworkState currentNetworkState;
    private ListItemClickListener listItemClickListener;
    public PageAdapter(@NonNull DiffUtil.ItemCallback <MainLst> diffCallback, Callback callback,ListItemClickListener listItemClickListener) {
        super(diffCallback);
        this.callback = callback;
        this.listItemClickListener=listItemClickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        switch (viewType) {
            case R.layout.loading_list_item:
                LoadingListItemBinding loadingListItemBinding =
                        LoadingListItemBinding.inflate(layoutInflater, parent, false);
                return new LoadingHolder(loadingListItemBinding);
            case R.layout.network_failure_list_item:
                NetworkFailureListItemBinding networkFailureListItemBinding =
                        NetworkFailureListItemBinding.inflate(layoutInflater, parent, false);
                NetworkFailureHolder networkFailureHolder = new NetworkFailureHolder(networkFailureListItemBinding);
                networkFailureHolder.binding.retry.setOnClickListener(v -> callback.onRetryClicked());
                return networkFailureHolder;
            case R.layout.main_ui_listing:
            default:
                MainUiListingBinding  showListItemBinding =
                    MainUiListingBinding.inflate(layoutInflater, parent, false);
                return new ShowHolder(showListItemBinding,listItemClickListener);
        }
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case R.layout.loading_list_item:
                LoadingHolder loadingHolder = (LoadingHolder) holder;
                loadingHolder.binding.spinner.setVisibility(View.VISIBLE);
                break;
            case R.layout.network_failure_list_item:
                NetworkFailureHolder networkHolder = (NetworkFailureHolder) holder;
                networkHolder.binding.networkPbm.setText(currentNetworkState.message());
                break;
            default:
            case R.layout.main_ui_listing:
                MainLst show = getItem(position);
                ShowHolder showHolder = (ShowHolder) holder;
                showHolder.binding.setMain(show);
                assert show != null;

                    String rat= String.valueOf(show.getRating());
                    showHolder.binding.ratnum.setText(rat);

                if (show.getCountry() != null) {
                    showHolder.binding.proploc.setText(show.getCountry());
                }

                    String bdn= String.valueOf(show.getBdNumbr());
                    showHolder.binding.bedid.setText(bdn);

                if (show.getProperty_nam() != null) {
                    showHolder.binding.propnam.setText(show.getProperty_typ());
                }
                if (show.getProperty_typ() != null) {
                    showHolder.binding.proptype.setText(show.getProperty_nam());
                }

                showHolder.binding.maincont.setOnClickListener(view -> listItemClickListener.onItemClick(view,show));
                configureImage(showHolder, show);
                break;
        }
    }
    private void configureImage(ShowHolder holder, @NonNull MainLst show) {
        if (show.getImages() != null) {
            Glide.with(context).load(show.getImages().get(0).getImaguri())
                    .apply(RequestOptions.placeholderOf(R.color.ghostWite))
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(holder.binding.lisImag);
        }
    }

    public void setNetworkState(NetworkState newNetworkState) {
        NetworkState previousNetworkState = currentNetworkState;
        boolean hadExtraRow = hasExtraRow();
        currentNetworkState = newNetworkState;
        boolean hasExtraRow = hasExtraRow();
        if (hadExtraRow != hasExtraRow) {
            if (hadExtraRow) {
                notifyItemRemoved(super.getItemCount());
            } else {
                notifyItemInserted(super.getItemCount());
            }
        } else if (hasExtraRow && !previousNetworkState.equals(newNetworkState)) {
            notifyItemChanged(getItemCount() - 1);
        }
    }

    @Override
    public int getItemCount() {
        return super.getItemCount() + getExtraRow();
    }

    // Add an item for the network state
    private int getExtraRow() {
        if (hasExtraRow()) return 1;
        else return 0;
    }

    @Override
    public int getItemViewType(int position) {
        // Reached at the end
        if (hasExtraRow() && position == getItemCount() - 1) {
            if (currentNetworkState.status() == NetworkState.Status.LOADING) {
                return R.layout.loading_list_item;
            } else {
                return R.layout.network_failure_list_item;
            }
        } else {
            return R.layout.main_ui_listing;
        }
    }

    private boolean hasExtraRow() {
        return currentNetworkState != null && currentNetworkState.status() != NetworkState.Status.SUCCESS;
    }

    static class ShowHolder extends RecyclerView.ViewHolder {
        private MainUiListingBinding binding;

        ShowHolder(MainUiListingBinding itemBinding, ListItemClickListener listItemClickListener) {
            super(itemBinding.getRoot());
            this.binding = itemBinding;

        }
    }

    static class LoadingHolder extends RecyclerView.ViewHolder {
        private LoadingListItemBinding binding;

        LoadingHolder(LoadingListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    static class NetworkFailureHolder extends RecyclerView.ViewHolder {
        private NetworkFailureListItemBinding binding;

        NetworkFailureHolder(NetworkFailureListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public interface Callback {
        void onRetryClicked();
    }



}
