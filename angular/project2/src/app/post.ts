import { User } from './user';

export class Post {
    id: number;
    owner: User;
    title: string;
    startDate: string;
    endDate: string;
    description: string;
    latitude: number;
    longitude: number;
    price: number;
  }
