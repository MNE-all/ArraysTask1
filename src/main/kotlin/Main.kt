import java.lang.Exception

fun main() {
    println("Программа по подсчёту уникальных цифр")
    print("Введите количество строк массива: ")
    val stringAmount = readln().toInt()
    print("Введите количество столбцов массива: ")
    val columnAmount = readln().toInt()
    val userArray: Array<Array<Int>> = Array(stringAmount) { Array(columnAmount) {0} }
    // Заполение массива
    for (string in 0 until stringAmount) {
        for (column in 0 until columnAmount) {
            userArray[string][column] = threeDigitNumberValidate("Введите трёхзначное число для ячейки [$string][$column]: ")
        }
    }
    // Вывод массива
    for (string in 0 until stringAmount) {
        for (column in 0 until columnAmount) {
            print("${userArray[string][column]} ")
        }
        println()
    }
    // Отображение результата
    println("В массиве использовано ${dictionaryOfNumbers(userArray)} различных цифр")
}


fun threeDigitNumberValidate(message: String): Int {
    print(message)
    val userInput: Int
    try {
        userInput = readln().toInt()
        if (userInput.toString().length != 3) {
            println("Введено не трёхзначаное число!")
            return threeDigitNumberValidate(message)
        }
    }
    catch (e: Exception){
        println("Ошибка ввода!\nВведите корректные данные")
        return threeDigitNumberValidate(message)
    }
    return userInput
}

fun dictionaryOfNumbers(mas: Array<Array<Int>>): Int {
    var numbers: MutableSet<Char> = mutableSetOf()
    for (row in mas){
        for (column in row){
            for (number in column.toString()){
                numbers.add(number)
            }
        }
    }
    return numbers.size
}