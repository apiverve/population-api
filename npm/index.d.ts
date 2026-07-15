declare module '@apiverve/population' {
  export interface populationOptions {
    api_key: string;
    secure?: boolean;
  }

  /**
   * Describes fields the current plan does not unlock. Locked fields arrive as null
   * in `data`; `locked_fields` names them, using dot paths for nested fields.
   * Absent when the plan unlocks everything.
   */
  export interface PremiumInfo {
    message: string;
    upgrade_url: string;
    locked_fields: string[];
  }

  export interface populationResponse {
    status: string;
    error: string | null;
    data: PopulationDataData;
    code?: number;
    premium?: PremiumInfo;
  }


  interface PopulationDataData {
      country:             null | string;
      countryISO3:         null | string;
      countryName:         null | string;
      year:                number | null;
      population:          number | null;
      populationFormatted: null | string;
      growthRate:          number | null;
      density:             number | null;
      densityUnit:         null | string;
      urbanPercent:        number | null;
      ruralPercent:        number | null;
      urbanPopulation:     number | null;
      ruralPopulation:     number | null;
      lifeExpectancy:      number | null;
      lastUpdated:         Date | null;
  }

  export default class populationWrapper {
    constructor(options: populationOptions);

    execute(callback: (error: any, data: populationResponse | null) => void): Promise<populationResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: populationResponse | null) => void): Promise<populationResponse>;
    execute(query?: Record<string, any>): Promise<populationResponse>;
  }
}
