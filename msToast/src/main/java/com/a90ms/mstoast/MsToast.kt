package com.a90ms.mstoast

import android.animation.Animator
import android.animation.ObjectAnimator
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.a90ms.mstoast.databinding.LayoutMsToastBinding

fun Fragment.msToast(messageId: Int, length: Long = MS_LONG) =
    msToast(getString(messageId), length)

fun Fragment.msToast(message: String, length: Long = MS_LONG) =
    activity?.msToast(message, length)

// TODO Dynamic Align, Dynamic Margin, Dynamic Style
fun Activity.msToast(
    message: String,
    length: Long = MS_LONG,
    align: MsToastAlign = MsToastAlign.TOP
) {
    val rootView: ViewGroup =
        (findViewById<View>(android.R.id.content) as ViewGroup).getChildAt(0) as ViewGroup

    rootView.findViewById<View>(R.id.ms_toast)?.let {
        rootView.removeView(it)
    }

    val toastBinding = DataBindingUtil.inflate<LayoutMsToastBinding>(
        LayoutInflater.from(this),
        R.layout.layout_ms_toast,
        rootView,
        true
    )
    toastBinding.root.id = R.id.ms_toast
    toastBinding?.tvToast?.text = message

    // TODO align

    startAnimation(toastBinding.root, length, rootView)
}

fun startAnimation(root: View, length: Long, viewGroup: ViewGroup) {
    ObjectAnimator.ofFloat(
        root,
        "alpha",
        1f,
        0f
    ).apply {
        startDelay = length
        duration = 500
        addListener(
            object : Animator.AnimatorListener {
                override fun onAnimationStart(animation: Animator?) {
                }

                override fun onAnimationEnd(animation: Animator?) {
                    viewGroup.removeView(root)
                }

                override fun onAnimationCancel(animation: Animator?) {
                }

                override fun onAnimationRepeat(animation: Animator?) {
                }
            }
        )
    }.also {
        it.start()
    }
}
