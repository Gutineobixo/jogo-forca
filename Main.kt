fun main() {
    val palavras = listOf("abacaxi", "computador", "elefante", "girafa", "chocolate")
    val palavraEscolhida = palavras.random()
    var tentativasRestantes = 8
    var palavraMostrada = CharArray(palavraEscolhida.length) { '_' }
    var acertos = 0
    var erros = 0

    println("Bem-vindo ao Jogo da Forca!")

    while (tentativasRestantes > 0 && acertos < palavraEscolhida.length) {
        println("Palavra: ${palavraMostrada.joinToString(" ")}")
        println("Tentativas restantes: $tentativasRestantes")
        print("Digite uma letra: ")
        val entrada = readLine()!!

        if (entrada.length == 1) {
            val letra = entrada[0]

            var acertou = false
            for (i in palavraEscolhida.indices) {
                if (palavraEscolhida[i] == letra && palavraMostrada[i] == '_') {
                    palavraMostrada[i] = letra
                    acertou = true
                    acertos++
                }
            }

            if (!acertou) {
                tentativasRestantes--
                erros++
                println("Errado! Você perdeu uma tentativa.")
            }
        } else {
            println("Por favor, digite apenas uma letra.")
        }
    }

    if (acertos == palavraEscolhida.length) {
        println("Parabéns! Você ganhou! A palavra era: $palavraEscolhida")
    } else {
        println("Game Over! A palavra era: $palavraEscolhida")
    }
}