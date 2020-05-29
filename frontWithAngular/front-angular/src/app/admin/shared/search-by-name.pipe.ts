import { Pipe, PipeTransform } from '@angular/core';
import {CommonFields} from "../../shared/services/interfaces";

@Pipe({
  name: 'searchByName'
})
export class SearchByNamePipe implements PipeTransform {

  transform(list: CommonFields[], nameStr: string): unknown {
    return list.filter(elem => elem.name.toLowerCase().startsWith(nameStr.toLowerCase()));
  }
}
