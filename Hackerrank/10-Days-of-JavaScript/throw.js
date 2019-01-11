function isPositive(a) {
    try {
        if (a < 0) {
            throw 'Negative Error';
        } else if (a == 0) {
            throw 'Zero Error';
        } else {
            return 'YES'
        }
    } catch(err) {
        return err;
    }
}
/*
function isPositive(a) {
    if (a == 0) {
        throw new Error('Zero Error);
    }
    if (a < 0) {
        throw new Error('Negative Error');
    }
    return 'YES';
}