package com.wunder.wundercarsapp.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wunder.wundercarsapp.R;
import com.wunder.wundercarsapp.model.Placemark;
import com.wunder.wundercarsapp.modules.main_activity.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class WunderCarsAdapter extends RecyclerView.Adapter<WunderCarsAdapter.WunderCarsViewHolder> {

    private List<Placemark> carsList;
    private RecyclerItemClickListener recyclerItemClickListener;

    public WunderCarsAdapter(List<Placemark> carsList, RecyclerItemClickListener recyclerItemClickListener) {
        this.carsList = carsList;
        this.recyclerItemClickListener = recyclerItemClickListener;
    }

    @NonNull
    @Override
    public WunderCarsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.single_view_row, parent, false);
        return new WunderCarsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WunderCarsViewHolder holder, final int position) {
        holder.tvName.setText(carsList.get(position).getName());
        holder.tvVin.setText(carsList.get(position).getVin());
        holder.tvAddress.setText(carsList.get(position).getAddress());
        holder.tvCoordinates.setText(String.valueOf(carsList.get(position).getCoordinates()));
        holder.tvExterior.setText(carsList.get(position).getExterior());
        holder.tvInterior.setText(carsList.get(position).getInterior());
        holder.tvEngineType.setText(carsList.get(position).getEngineType());
        holder.tvFuel.setText(String.valueOf(carsList.get(position).getFuel()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerItemClickListener.onItemClick(carsList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return carsList.size();
    }

    class WunderCarsViewHolder extends RecyclerView.ViewHolder{

        TextView tvName, tvVin, tvAddress, tvCoordinates, tvExterior, tvInterior, tvEngineType, tvFuel;

         WunderCarsViewHolder(View itemView) {
            super(itemView);
            tvName =  itemView.findViewById(R.id.tvName);
            tvVin =  itemView.findViewById(R.id.tvVin);
            tvAddress =  itemView.findViewById(R.id.tvAddress);
            tvCoordinates =  itemView.findViewById(R.id.tvCoordinates);
            tvExterior =  itemView.findViewById(R.id.tvExterior);
            tvInterior =  itemView.findViewById(R.id.tvInterior);
            tvEngineType =  itemView.findViewById(R.id.tvEngineType);
            tvFuel =  itemView.findViewById(R.id.tvFuel);

        }
    }
}
