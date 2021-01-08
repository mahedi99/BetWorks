package com.mahedi.betworks.ui.login

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.mahedi.betworks.data.model.HasType

/**
 * @author Mahedi Hassan
 * 2021-01-07
 */

abstract class BaseViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {
    abstract fun bind(data: HasType, position: Int)
}