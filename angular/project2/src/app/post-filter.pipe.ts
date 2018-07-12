import { Pipe, PipeTransform } from '@angular/core';

import { Post } from './post'

@Pipe({
  name: 'postFilter'
})

export class PostFilterPipe implements PipeTransform {

  transform(posts: Post[], searchString?: string, maxPrice?: number): Post[] {
    if (!posts){
      return [];
    }

    // else if (!isNaN(((Number)(searchString))))
    // {
    //   console.log((Number)(searchString));
      // return posts.filter( post => {
      //   let match: boolean;
      //   match = post.price <= ((Number)(searchString));
      //   return match;
      // })
    // }
    // else
    // {
    searchString = searchString.toUpperCase();
    if(maxPrice == null || maxPrice == 0)
    {
      maxPrice = 1000000000000;
    }
    return posts.filter( post => {
      let match: boolean;
      match = (post.title.toUpperCase().includes(searchString) || post.description.toUpperCase().includes(searchString)) && post.price <= maxPrice;
      return match;
    })
    // }
    
  }

}
