package br.edu.infnet.appcriptografia

import java.util.*

object Utility {
    private const val alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    private var index = 0
    private var updated_index = 0
    private var final_index = 0
    private var index_p_t_l = 0
    private var index_s_t_l = 0
    private var plainTxt: String? = null
    private var cipherTxt: String? = null
    private var finalTxt: String? = null

    fun encrypt1(plaintext: String, encrptionKey: Int): String? {
        var plaintext = plaintext
        reset()
        plaintext = plaintext.uppercase(Locale.getDefault())
        index = 0
        while (index < plaintext.length) {
            if (plaintext[index] != ' ') {
                index_p_t_l = alphabet.indexOf(plaintext[index])
                updated_index = encrptionKey + alphabet.indexOf(plaintext[index])
                final_index = if (updated_index >= alphabet.length) {
                    updated_index - alphabet.length
                } else updated_index
                cipherTxt = alphabet.substring(final_index, final_index + 1)
                finalTxt += cipherTxt
            }
            index++
        }
        return finalTxt
    }

    fun decrypt1(ciphertext: String, decryptionKey: Int): String? {
        var ciphertext = ciphertext
        reset()
        ciphertext = ciphertext.uppercase(Locale.getDefault())
        index = 0
        while (index < ciphertext.length) {
            if (ciphertext[index] != ' ') {
                index_p_t_l = alphabet.indexOf(ciphertext[index])
                index_s_t_l = index_p_t_l
                updated_index = alphabet.indexOf(ciphertext[index]) - decryptionKey
                final_index = if (updated_index < 0) {
                    updated_index + alphabet.length
                } else updated_index
                plainTxt = alphabet.substring(final_index, final_index + 1)
                finalTxt += plainTxt
            }
            index++
        }
        return finalTxt
    }

    private fun reset() {
        finalTxt = ""
    }
}
