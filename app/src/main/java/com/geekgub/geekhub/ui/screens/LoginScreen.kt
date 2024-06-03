package com.geekgub.geekhub.ui.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.geekgub.geekhub.ui.theme.CardBackground
import com.geekgub.geekhub.ui.theme.DetailColor
import com.geekgub.geekhub.ui.theme.GrayColor

@Composable
fun LoginScreen() {

    /**
     * Trying comits from linux to windows
     */

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var text by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var passwordVisible by remember { mutableStateOf(false) }

        val signUpText = buildAnnotatedString {
            append("Don't have an account? ")

            withStyle(style = SpanStyle(color = DetailColor, textDecoration = TextDecoration.Underline, fontWeight = FontWeight.Bold)) {
                append("Sign up")
            }
        }

        Text(text = "GeekHub", fontSize = 32.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(16.dp))


        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(32.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(color = CardBackground)
        ) {
            Column(modifier = Modifier.padding(10.dp)) {
                TextField(
                    value = text,
                    onValueChange = { newText -> text = newText },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    label = { Text("Email") },
                    singleLine = true,
                    shape = RoundedCornerShape(10.dp),
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Email, contentDescription = "Email" )
                    },
                    colors = TextFieldDefaults.colors(
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent
                    ),
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                )
                TextField(
                    value = password,
                    onValueChange = { newPassword -> password = newPassword },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    label = { Text("Password") },
                    singleLine = true,
                    shape = RoundedCornerShape(10.dp),
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Lock, contentDescription = "Password" )
                    },
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    colors = TextFieldDefaults.colors(
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent
                    ),
                    trailingIcon = {
                        val image = if (passwordVisible) Icons.Default.CheckCircle else Icons.Default.Close
                        
                        IconButton(onClick = { passwordVisible = !passwordVisible }) {
                            Icon(imageVector = image, contentDescription = "Password visibility")
                        }
                    },
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                )
                Button(
                    onClick = { /*FUNCTIONALITY*/ },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text("Login")
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp) // Give the Box some height to see the line better
                ) {
                    Canvas(modifier = Modifier.fillMaxSize()) {
                        val width = size.width
                        drawLine(
                            color = GrayColor,
                            start = Offset(0f, size.height / 2),
                            end = Offset(width, size.height / 2),
                            strokeWidth = 5f
                        )
                    }
                }
                Text(text = "Forgot your password?", textDecoration = TextDecoration.Underline, modifier = Modifier.padding(8.dp).clickable { /*FUNCTIONALITY*/ })
                Text(text = signUpText, modifier = Modifier.padding(8.dp).clickable { /*FUNCTIONALITY*/ })
            }
        }
    }

}