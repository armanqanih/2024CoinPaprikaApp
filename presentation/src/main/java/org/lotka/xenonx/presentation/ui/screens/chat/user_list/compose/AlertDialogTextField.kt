package org.lotka.xenonx.presentation.ui.screens.chat.user_list.compose

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text

import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged


@Composable
fun AlertDialogCustomOutlinedTextField(
    entry: String,
    hint: String,
    onChange:(String) -> Unit = {},
    onFocusChange:(Boolean) -> Unit = {}){

    var isNameChange by remember { mutableStateOf(false) }
    var isFocusChange by remember { mutableStateOf(false) }


    var text by remember { mutableStateOf("") }
    text = entry

    val fullWidthModifier = Modifier
        .fillMaxWidth()
        .onFocusChanged {
            if (isNameChange) {
                isFocusChange = true
                onFocusChange(isFocusChange)
            }
        }

    OutlinedTextField(
        modifier = fullWidthModifier,
        singleLine = true,
        value = text,
        label = {Text(hint)},
        onValueChange = {
            text = it
            onChange(it)
            isNameChange = true
        })
}