declare module '@apiverve/population' {
  export interface populationOptions {
    api_key: string;
    secure?: boolean;
  }

  export interface populationResponse {
    status: string;
    error: string | null;
    data: PopulationDataData;
    code?: number;
  }


  interface PopulationDataData {
      country:             string;
      countryISO3:         string;
      countryName:         string;
      year:                number;
      population:          number;
      populationFormatted: string;
      growthRate:          number;
      density:             number;
      densityUnit:         string;
      urbanPercent:        number;
      ruralPercent:        number;
      urbanPopulation:     number;
      ruralPopulation:     number;
      lifeExpectancy:      number;
      lastUpdated:         Date;
  }

  export default class populationWrapper {
    constructor(options: populationOptions);

    execute(callback: (error: any, data: populationResponse | null) => void): Promise<populationResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: populationResponse | null) => void): Promise<populationResponse>;
    execute(query?: Record<string, any>): Promise<populationResponse>;
  }
}
