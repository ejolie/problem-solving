class Polygon {
  constructor(sides) {
    this.sides = sides;
  }

  perimeter() {
    return this.sides.reduce(function add(a,b) {return a+b;})
    // ES6
    // return this.sides.reduce((a,b) => a+b)
  }
}