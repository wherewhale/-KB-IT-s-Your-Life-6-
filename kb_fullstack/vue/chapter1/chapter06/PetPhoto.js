import { Pet } from './Pet.js';

export class PetPhoto extends Pet {
  constructor(
    name,
    species,
    birthDate,
    photoPath,
    uploadDate = new Date(),
    type = 'Photo'
  ) {
    super(name, species, birthDate);
    this.photoPath = photoPath;
    this.uploadDate = uploadDate;
    this.type = type;
  }
}
