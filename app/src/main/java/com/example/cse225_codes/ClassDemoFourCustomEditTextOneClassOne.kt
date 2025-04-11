package com.example.cse225_codes

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.TypedArray
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.res.ResourcesCompat

class ClassDemoFourCustomEditTextOneClassOne(context: Context, attrs: AttributeSet?) : AppCompatEditText(context, attrs) {

    private var setHint: String? = null
    private var setColor = false
    private var darkButton: Drawable? = null
    private var lightButton: Drawable? = null

    init {
        val typedArray: TypedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomEditText1)
        try {
            setHint = typedArray.getString(R.styleable.CustomEditText1_setHint) ?: "Enter your message"
            hint = setHint  // Apply hint

            setColor = typedArray.getBoolean(R.styleable.CustomEditText1_setColor, true)
            if (setColor) {
                setTextColor(Color.RED)
            }
        } finally {
            typedArray.recycle()
        }
        init()
    }

    private fun init() {
        darkButton = ResourcesCompat.getDrawable(resources, R.drawable.dark_button_one, null)
        lightButton = ResourcesCompat.getDrawable(resources, R.drawable.light_button_one, null)

        addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // No action needed
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                showButton()
            }

            override fun afterTextChanged(s: Editable?) {
                // No action needed
            }
        })
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun showButton() {
        setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_UP) {
                val clearButtonStart = (width - paddingEnd - (darkButton?.intrinsicWidth ?: 0)).toFloat()
                if (event.x > clearButtonStart) {
                    text?.clear()
                    hideButton()
                    return@setOnTouchListener true
                }
            }
            false
        }
        show()
    }

    private fun show() {
        setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, darkButton, null)
    }

    private fun hideButton() {
        setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, lightButton, null)
    }
}
