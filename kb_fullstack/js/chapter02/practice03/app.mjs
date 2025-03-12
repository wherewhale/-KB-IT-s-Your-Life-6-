import { grillMeat } from './grill.mjs';

async function startGrilling() {
  try {
    const result = grillMeat('삼겹살');
    console.log(result);
  } catch (error) {
    console.error(error);
  }
}

startGrilling();
