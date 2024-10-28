package com.example.pertemuan5

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable

fun Latihaninput(modifier: Modifier = Modifier){

    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var notelpon by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }

    var dataGender = listOf("Laki-Laki", "Perempuan")

    var confNama by remember { mutableStateOf("") }
    var confEmail by remember { mutableStateOf("") }
    var confAlamat by remember { mutableStateOf("") }
    var confNotelpon by remember { mutableStateOf("") }
    var confGender by remember { mutableStateOf("") }

    Column(
        modifier = modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally
    ){
        TextField(
            value = nama,
            onValueChange = {nama = it},
            label = {
                Text(text = "Nama")
            },
            placeholder = {
                Text(text = "isi nama anda")
            },
            modifier = modifier.fillMaxWidth().padding(5.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            dataGender.forEach{selectedGender->
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ){
                    RadioButton(
                        selected = gender == selectedGender,
                        onClick = {gender = selectedGender}
                    )
                    Text(text = selectedGender)
                }
            }
        }

        TextField(
            value = email,
            onValueChange = {email = it},
            label = {
                Text(text = "Email")
            },
            placeholder = {
                Text(text = "isi email anda")
            },
            modifier = modifier.fillMaxWidth().padding(5.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        TextField(
            value = alamat,
            onValueChange = {alamat = it},
            label = {
                Text(text = "Alamat")
            },
            placeholder = {
                Text(text = "isi alamat anda")
            },
            modifier = modifier.fillMaxWidth().padding(5.dp),
        )

        TextField(
            value = notelpon,
            onValueChange = {notelpon = it},
            label = {
                Text(text = "No Telpon")
            },
            placeholder = {
                Text(text = "isi no anda")
            },
            modifier = modifier.fillMaxWidth().padding(5.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Button(onClick ={
            confNama = nama
            confEmail = email
            confAlamat = alamat
            confNotelpon = notelpon
            confGender = gender
        } ) {
            Text(text = "Simpan")
        }
        Tampildata(param = "nama", argum = confNama)
        Tampildata(param = "email", argum = confNama)
        Tampildata(param = "alamat", argum = confNama)
        Tampildata(param = "notelpon", argum = confNama)
        Tampildata(param = "gender", argum = confGender)
    }
}

@Composable
fun Tampildata(param: String, argum:String){
    Column (
        modifier = Modifier.padding(16.dp)
    ){
        Row (
            modifier = Modifier.fillMaxWidth(),
            //horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(text = param, modifier = Modifier.weight(0.8f))
            Text(text = ":", modifier = Modifier.weight(0.2f))
            Text(text = argum, modifier = Modifier.weight(2f))
        }
    }
}