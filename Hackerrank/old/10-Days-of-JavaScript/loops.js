function vowelsAndConsonants(s) {
    const vowels = 'aeiou';
    let consonants = '';

    for (let v of s) {
        if (vowels.includes(v)) {
            console.log(v);
        } else {
            consonants += v + '\n';
        }
    }
    console.log(consonants.trim());
}