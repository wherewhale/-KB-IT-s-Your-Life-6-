import { Pet } from './Pet.js';

// "name": "나비",
// "species": "고양이",
// "adoptionDate": "2023-03-10",
// "description": "처음으로 캣타워를 올랐어요!",
// "recordDate": "2025-03-14",
// "type": "Growth Record"

export class PetGrowthRecord extends Pet {
  constructor(
    name,
    species,
    adoptionDate,
    description,
    recordDate = new Date(),
    type = 'Growth Record'
  ) {
    super(name, species, adoptionDate);
    this.description = description;
    this.recordDate = recordDate;
    this.type = type;
  }
}
