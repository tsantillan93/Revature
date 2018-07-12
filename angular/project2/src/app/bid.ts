import { User } from './user';

export class Bid {
    id: number;
    post: number;
    user: User;
    amount: number;
}