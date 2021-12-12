// Nombre: Jose Manuel Dominguez Morales
// Correo: pepedoguez@gmail.com

// 1.- Implementa una función que determine si una cadena de texto dada esta formada por
//      caracteres únicos, considera mayúsculas, minúsculas.
function hasUniqueCharacters(word) {
	let caracteres = new Set();
	for (caracter of word) {
		if (caracteres.has(caracter)) {
			return false;
		}
		caracteres.add(caracter);
	}
	return true;
}

//Por Ejemplo
console.log(hasUniqueCharacters('String')); // true
console.log(hasUniqueCharacters('Some String')); // false

//2.- Escribe un programa que guarde en un array e imprima los números primos dentro de un rango
//dado.
function isPrime(number) {
	let aux = number;
	for (let i = aux - 1; i > 1; i--) {
		if (aux % i === 0) return false;
	}
	return true;
}
function primeNumbers(start, end) {
	let primos = [];
	start = start === 1 ? 2 : start;
	for (let i = start; i <= end; i++) {
		if (isPrime(i)) primos.push(i);
	}
	console.log(primos);
}
//Salida
primeNumbers(1, 20); // [3, 5, 7, …]
primeNumbers(30, 100); // [31, 37, 41, …]


