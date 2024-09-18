import http from 'k6/http';
import { sleep } from 'k6';
import { BASEURL } from './config.js';

export const options = {
  vus: 1,
  duration: '10s',
};

export default function () {
  http.get(BASEURL + '/pets?tags=cat&limit=10');
  sleep(1);
}