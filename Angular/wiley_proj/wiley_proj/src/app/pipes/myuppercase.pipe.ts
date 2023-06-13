import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'myuppercase'
})
export class MyuppercasePipe implements PipeTransform {

  transform(value: string): string {
    if(!value){
      return value;
    }

    if(typeof value!=='string'){
      throw Error("Invalid argument");
    }
    return value.toUpperCase();
  }

}
