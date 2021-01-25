 package com.example.networkingassignment.album.presentation

import android.view.View
import android.widget.TextView
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.airbnb.epoxy.EpoxyAttribute
import com.example.networkingassignment.album.R
import kotlinx.android.synthetic.main.album_name.view.*


 @EpoxyModelClass
abstract class AlbumItemModel : EpoxyModelWithHolder<AlbumItemModel.ViewHolder>() {

    override fun getDefaultLayout(): Int {
        return R.layout.album_name
    }

  @EpoxyAttribute
    var userId : Int = 0

    @EpoxyAttribute
    var albumId : Int = 0

    @EpoxyAttribute
    lateinit var title: String

    @EpoxyAttribute(EpoxyAttribute.Option.DoNotHash)
    var clickListener: View.OnClickListener? = null


    override fun bind(holder: ViewHolder) {
        super.bind(holder)

        holder.textUserID.text = "" + userId
        holder.textID.text =  "" + albumId
        holder.textTitle.text = title
        holder.cardView.setOnClickListener(clickListener)
    }

    override fun unbind(holder: ViewHolder) {
        super.unbind(holder)
        holder.cardView.setOnClickListener(null)
    }

    class ViewHolder : BaseEpoxyHolder() {
        lateinit var cardView: View
        lateinit var textUserID: TextView
        lateinit var textID : TextView
        lateinit var textTitle : TextView


        override fun bindView(itemView: View) {
            super.bindView(itemView)
            itemView.let {
                cardView = it.card
                textUserID = it.txt_userId
                textID = it.txt_id
                textTitle = it.txt_title
            }
        }
    }
}