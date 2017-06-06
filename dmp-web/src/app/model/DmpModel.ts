export class DmpModel{

  name: string;
  version: string;
  date: string;
  description:string;
  dataObjects: DataObject[];
  researchers: Researcher[];
  website: string;
}

export class DataObject{
  title: string;
  fullname: string;
  description: string;
  license: string;
  privacy: Privacy;
  DOI: string;
}

export class File extends DataObject{
  metadata: Metadata;
  storage: string;
}

export class SourceCode extends DataObject{
  repository: string;
  documentation: string;
}

export class Container extends DataObject{
  documentation: string;
  repository: string;
}

export class Researcher {
  name: string;
  role: string;
  orcid: string;
}

export class Privacy{
  securityLevel: string;
  hasPrivacyRelevantInfo: boolean;
}

export class Metadata {
  format: string;
  hash: string;

}
