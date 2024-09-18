import http from 'k6/http';
import { sleep } from 'k6';
import { BASEURL } from './config.js';

export const options = {
  stages: [
    {
      duration: '10s',
      target: 10
    },
    {
      duration: '30s',
      target: 20
    },
    {
      duration: '10s',
      target: 0
    }
  ]
};

export default function () {
  http.get(BASEURL);
  sleep(1);
}