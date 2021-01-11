 package com.example.networkingassignment

import android.annotation.SuppressLint
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import kotlinx.android.synthetic.main.item_name.view.*
import java.lang.Package.getPackage
import com.airbnb.epoxy.EpoxyAttribute as EpoxyAttribute1

@SuppressLint("NonConstantResourceId")
@EpoxyModelClass(layout = R.layout.item_name)
abstract class NameItemModel : EpoxyModelWithHolder<NameItemModel.ViewHolder>() {


  @EpoxyAttribute1
    var userId : Int = 0

    @EpoxyAttribute1
    var p_id : Int = 0

    @EpoxyAttribute1
    lateinit var title: String

    @EpoxyAttribute1
    lateinit var body: String


    override fun bind(holder: ViewHolder) {
        super.bind(holder)

        holder.textUserID.text = "" + userId
        holder.textID.text =  "" + p_id
        holder.textTitle.text = title
        holder.textBody.text = body
    }

    class ViewHolder : BaseEpoxyHolder() {
        lateinit var textUserID: TextView
        lateinit var textID : TextView
        lateinit var textTitle : TextView
        lateinit var textBody : TextView


        override fun bindView(itemView: View) {
            super.bindView(itemView)
            itemView.let {
                textUserID = it.txt_userId
                textID = it.txt_id
                textTitle = it.txt_title
                textBody = it.txt_body
            }
        }
    }
}